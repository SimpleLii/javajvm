package com.github.anilople.javajvm.instructions.stores;

import com.github.anilople.javajvm.instructions.BytecodeReader;
import com.github.anilople.javajvm.instructions.Instruction;
import com.github.anilople.javajvm.runtimedataarea.Frame;
import com.github.anilople.javajvm.utils.PrimitiveTypeUtils;

/**
 * Operation:
 *      Store int into local variable
 * Description:
 *      The <n> must be an index into the local variable array of the
 *      current frame (§2.6). The value on the top of the operand stack
 *      must be of type int . It is popped from the operand stack, and the
 *      value of the local variable at <n> is set to value.
 * Notes:
 *      Each of the istore_<n> instructions is the same as istore with an
 *      index of <n>, except that the operand <n> is implicit.
 */
public class ISTORE_0 implements Instruction {

    @Override
    public void FetchOperands(BytecodeReader bytecodeReader) {

    }

    @Override
    public void Execute(Frame frame) {
        ISTORE.Execute(frame, 0);
    }

}