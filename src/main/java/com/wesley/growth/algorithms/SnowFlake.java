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
     * 数据中心的最大序列号
     */
    private final static long MAX_DATACENTER_ID = -1L ^ (-1L << DATACENTER_BITS);

    /**
     * 工作机器的最大序列号
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
}
