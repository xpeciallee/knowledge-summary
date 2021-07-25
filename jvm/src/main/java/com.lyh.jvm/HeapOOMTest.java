package com.lyh.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOMTest {
    /**
     * VM Flags:
     * Non-default VM flags: -XX:CICompilerCount=3 -XX:InitialHeapSize=1073741824 -XX:MaxHeapSize=1073741824 -XX:M
     * axNewSize=357564416 -XX:MinHeapDeltaBytes=524288 -XX:NewSize=357564416 -XX:OldSize=716177408 -XX:+UseCompre
     * ssedClassPointers -XX:+UseCompressedOops -XX:+UseFastUnorderedTimeStamps -XX:-UseLargePagesIndividualAlloca
     * tion -XX:+UseParallelGC
     */
    byte[] bytes=new byte[100*1024];
    public static void main(String[] args) throws InterruptedException {
            List<HeapOOMTest> list=new ArrayList<>();
            while(true){
                list.add(new HeapOOMTest());
                Thread.sleep(100);
            }

    }
}
