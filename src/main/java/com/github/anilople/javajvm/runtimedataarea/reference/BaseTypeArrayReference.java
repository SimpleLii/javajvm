package com.github.anilople.javajvm.runtimedataarea.reference;

import com.github.anilople.javajvm.constants.ArrayTypeCodes;
import com.github.anilople.javajvm.heap.JvmClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BaseTypeArrayReference extends ArrayReference {

    private static final Logger logger = LoggerFactory.getLogger(BaseTypeArrayReference.class);

    /**
     * base type code
     */
    private byte typeCode;

    private boolean[] booleans;

    private byte[] bytes;

    private char[] chars;

    private short[] shorts;

    private int[] ints;

    private long[] longs;

    private float[] floats;

    private double[] doubles;

    public BaseTypeArrayReference(JvmClassLoader jvmClassLoader, byte typeCode, int count) {
        this(jvmClassLoader, ArrayTypeCodes.typeCode2PrimitiveClass(typeCode), count);
    }

    public BaseTypeArrayReference(JvmClassLoader jvmClassLoader, Class<?> baseType, int count) {
        super(jvmClassLoader.loadClass(baseType), count);
        this.typeCode = ArrayTypeCodes.fromClass(baseType);
        logger.trace("array type code: {}, length: {}", typeCode, count);
        switch (typeCode) {
            case ArrayTypeCodes.T_BOOLEAN:
                booleans = new boolean[count];
                break;
            case ArrayTypeCodes.T_BYTE:
                bytes = new byte[count];
                break;
            case ArrayTypeCodes.T_CHAR:
                chars = new char[count];
                break;
            case ArrayTypeCodes.T_SHORT:
                shorts = new short[count];
                break;
            case ArrayTypeCodes.T_INT:
                ints = new int[count];
                break;
            case ArrayTypeCodes.T_LONG:
                longs = new long[count];
                break;
            case ArrayTypeCodes.T_FLOAT:
                floats = new float[count];
                break;
            case ArrayTypeCodes.T_DOUBLE:
                doubles = new double[count];
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + typeCode);
        }
    }

    public BaseTypeArrayReference(JvmClassLoader jvmClassLoader, boolean[] booleans) {
        super(jvmClassLoader.loadClass(boolean.class), booleans.length);
        this.typeCode = ArrayTypeCodes.T_BOOLEAN;
        this.booleans = booleans;
    }

    public BaseTypeArrayReference(JvmClassLoader jvmClassLoader, byte[] bytes) {
        super(jvmClassLoader.loadClass(byte.class), bytes.length);
        this.typeCode = ArrayTypeCodes.T_BYTE;
        this.bytes = bytes;
    }

    public BaseTypeArrayReference(JvmClassLoader jvmClassLoader, short[] shorts) {
        super(jvmClassLoader.loadClass(short.class), shorts.length);
        this.typeCode = ArrayTypeCodes.T_SHORT;
        this.shorts = shorts;
    }

    /**
     * construct from char array
     * @param chars
     */
    public BaseTypeArrayReference(JvmClassLoader jvmClassLoader, char[] chars) {
        super(jvmClassLoader.loadClass(char.class), chars.length);
        this.typeCode = ArrayTypeCodes.T_CHAR;
        this.chars = chars;
    }

    public BaseTypeArrayReference(JvmClassLoader jvmClassLoader, int[] ints) {
        super(jvmClassLoader.loadClass(int.class), ints.length);
        this.typeCode = ArrayTypeCodes.T_INT;
        this.ints = ints;
    }

    public BaseTypeArrayReference(JvmClassLoader jvmClassLoader, float[] floats) {
        super(jvmClassLoader.loadClass(float.class), floats.length);
        this.typeCode = ArrayTypeCodes.T_FLOAT;
        this.floats = floats;
    }

    public BaseTypeArrayReference(JvmClassLoader jvmClassLoader, long[] longs) {
        super(jvmClassLoader.loadClass(long.class), longs.length);
        this.typeCode = ArrayTypeCodes.T_LONG;
        this.longs = longs;
    }

    public BaseTypeArrayReference(JvmClassLoader jvmClassLoader, double[] doubles) {
        super(jvmClassLoader.loadClass(double.class), doubles.length);
        this.typeCode = ArrayTypeCodes.T_DOUBLE;
        this.doubles = doubles;
    }


    @Override
    public String toString() {
        String value = null;
        switch (typeCode) {
            case ArrayTypeCodes.T_BOOLEAN:
                value = "booleans=" + Arrays.toString(booleans);
                break;
            case ArrayTypeCodes.T_BYTE:
                value = "bytes=" + Arrays.toString(bytes);
                break;
            case ArrayTypeCodes.T_CHAR:
                value = "chars=" + Arrays.toString(chars);
                break;
            case ArrayTypeCodes.T_SHORT:
                value = "shorts=" + Arrays.toString(shorts);
                break;
            case ArrayTypeCodes.T_INT:
                value = "ints=" + Arrays.toString(ints);
                break;
            case ArrayTypeCodes.T_LONG:
                value = "longs=" + Arrays.toString(longs);
                break;
            case ArrayTypeCodes.T_FLOAT:
                value = "floats=" + Arrays.toString(floats);
                break;
            case ArrayTypeCodes.T_DOUBLE:
                value = "doubles=" + Arrays.toString(doubles);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + typeCode);
        }
        return "BaseTypeArrayReference{" + value + "}";
    }

    public byte getTypeCode() {
        return typeCode;
    }

    public boolean isBooleanType() {
        return typeCode == ArrayTypeCodes.T_BOOLEAN;
    }

    public boolean getBooleanValue(int index) {
        return booleans[index];
    }

    public byte getByteValue(int index) {
        return bytes[index];
    }

    public char getCharValue(int index) {
        return chars[index];
    }

    public short getShortValue(int index) {
        return shorts[index];
    }

    public int getIntValue(int index) {
        return ints[index];
    }

    public float getFloatValue(int index) {
        return floats[index];
    }

    public long getLongValue(int index) {
        return longs[index];
    }

    public double getDoubleValue(int index) {
        return doubles[index];
    }

    public void setBooleanValue(int index, boolean booleanValue) {
        booleans[index] = booleanValue;
    }

    public void setByteValue(int index, byte byteValue) {
        bytes[index] = byteValue;
    }

    public void setCharValue(int index, char charValue) {
        chars[index] = charValue;
    }

    public void setShortValue(int index, short shortValue) {
        shorts[index] = shortValue;
    }

    public void setIntValue(int index, int intValue) {
        ints[index] = intValue;
    }

    public void setFloatValue(int index, float floatValue) {
        floats[index] = floatValue;
    }

    public void setLongValue(int index, long longValue) {
        longs[index] = longValue;
    }

    public void setDoubleValue(int index, double doubleValue) {
        doubles[index] = doubleValue;
    }
}
