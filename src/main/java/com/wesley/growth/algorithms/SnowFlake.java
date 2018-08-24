package com.wesley.growth.algorithms;

/**
 * 雪花算法: 分布式系统Id生成算法
 * @author Created By Wesley On 2018/08/23
 */
public class SnowFlake {

    /**
     * 起始时间戳
     */
    private final static long START_STMP = 1535035588286L;

    /**
     * 机器标识占用的位数
     */
    private final static long MACHINE_BITS = 5L;

    /**
     * 数据中心占用的位数
     */
    private final static long DATACENTER_BITS = 5L;

    /**
     * 12位序列号
     */
    private final static long SEQUENCE_BITS = 12L;

    /**
     * 数据中心的最大序列号 31
     */
    private final static long MAX_DATACENTER_ID = -1L ^ (-1L << DATACENTER_BITS);

    /**
     * 工作机器的最大序列号 31
     */
    private final static long MAX_MACHINE_ID = -1L ^ (-1L << MACHINE_BITS);

    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BITS);

    /**
     * 向左偏移的位数
     */
    private final static long MATCHINE_SHIFT = SEQUENCE_BITS;
    private final static long DATACENTER_SHIFT = SEQUENCE_BITS + MACHINE_BITS;
    private final static long TIMESTAMP_SHIFT = SEQUENCE_BITS + MACHINE_BITS + DATACENTER_BITS;

    /**
     * 数据中心Id
     */
    private long datacenterId;

    /**
     * 机器标识
     */
    private long machineId;

    /**
     * 序列号
     */
    private long sequence = 0L;

    /**
     * 最近一次的时间戳
     */
    private long lastStmp = -1L;

    public SnowFlake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_ID or less than 0");
        }
        if (machineId > MAX_MACHINE_ID || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_ID or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 产生下一个ID
     */
    public synchronized long nextId() {
        long currStmp = newStamp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增, 位与运算保证计算的结果范围始终是 0-4095
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStmp = currStmp;

        // 时间戳 | 数据中心部分 | 机器标识 | 序列号
        return (currStmp - START_STMP) << TIMESTAMP_SHIFT | datacenterId << DATACENTER_SHIFT | machineId << MATCHINE_SHIFT | sequence;
    }

    private long getNextMill() {
        long mill = newStamp();
        while (mill <= lastStmp) {
            mill = newStamp();
        }
        return mill;
    }

    private long newStamp() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SnowFlake snowFlake = new SnowFlake(2, 3);

        for (int i = 0; i < 100; i++) {
            System.out.println(snowFlake.nextId());
        }
    }
}
