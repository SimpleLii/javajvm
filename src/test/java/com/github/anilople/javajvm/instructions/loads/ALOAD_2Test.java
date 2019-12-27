package com.github.anilople.javajvm.instructions.loads;

import com.github.anilople.javajvm.helper.HighOrderFunctions;
import com.github.anilople.javajvm.helper.JvmThreadFactory;
import com.github.anilople.javajvm.helper.JvmThreadRunner;
import com.github.anilople.javajvm.runtimedataarea.JvmThread;
import com.github.anilople.javajvm.runtimedataarea.Reference;
import com.github.anilople.javajvm.runtimedataarea.reference.NullReference;
import com.github.anilople.javajvm.runtimedataarea.reference.ObjectReference;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class ALOAD_2Test {


    public static void main(String[] args) {
        ALOAD_2Test v0 = new ALOAD_2Test();
        ALOAD_2Test v1 = v0;
        ALOAD_2Test v2 = v1;
        ALOAD_2Test v3 = v2;
        ALOAD_2Test v4 = v3;
    }

    private ObjectReference objectReference = null;

    private final Consumer<JvmThread> beforeALOAD_2ExecuteListener = jvmThread -> {
        Reference reference = jvmThread.currentFrame().getLocalVariables().getReference(2);
        assertFalse(reference instanceof NullReference);
        objectReference = (ObjectReference) reference;
    };

    private final Consumer<JvmThread> afterALOAD_1ExecuteListener = jvmThread -> {
        assertNotNull(objectReference);
        ObjectReference fromOperandStack = (ObjectReference) jvmThread.currentFrame().getOperandStacks().popReference();
        // they must be equal
        assertEquals(objectReference, fromOperandStack);
        jvmThread.currentFrame().getOperandStacks().pushReference(fromOperandStack);
    };

    @Test
    void execute() {

        JvmThreadRunner jvmThreadRunner = new JvmThreadRunner(JvmThreadFactory.makeSimpleInstance(this.getClass()));

        jvmThreadRunner.addBeforeInstructionExecutionListener(
                ALOAD_2.class,
                HighOrderFunctions.toInMainTrigger(this.getClass(), beforeALOAD_2ExecuteListener)
        );

        jvmThreadRunner.addAfterInstructionExecutionListener(
                ALOAD_2.class,
                HighOrderFunctions.toInMainTrigger(this.getClass(), afterALOAD_1ExecuteListener)
        );

        jvmThreadRunner.run();

    }
    
}