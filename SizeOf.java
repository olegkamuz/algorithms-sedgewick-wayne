public class SizeOf
{
    public static void main (String [] args) throws Exception
    {
        // Warm up all classes/methods we will use
        runGC ();
        usedMemory ();
        // Array to keep strong references to allocated objects
        final int count = 100000;
        Object [] objects = new Object [count];

        long heap1 = 0;
        // Allocate count+1 objects, discard the first one
        for (int i = -1; i < count; ++ i)
        {
            Object object = null;

            // Instantiate your data here and assign it to object
            if (args[0].equals("Accumulator")) object = new Accumulator();
            if (args[0].equals("Transaction")) {
                Date date = new Date(1,1,1970);
                object = new Transaction("man", date, 0.0);
            }
            if (args[0].equals("FixedCapacityStackOfStrings")) object = new FixedCapacityStackOfStrings(0);
            if (args[0].equals("Point2D")) object = new Point2D(0.0,0.0);
            if (args[0].equals("Interval1D")) object = new Interval1D(0.0,0.0);
            if (args[0].equals("Interval2D")) {
                Interval1D interval1 = new Interval1D(0.0,0.0);
                Interval1D interval2 = new Interval1D(0.0,0.0);
                if (args[0].equals("Interval1D")) object = new Interval1D(0.0,0.0);
                object = new Interval2D(interval1, interval2);
            }
            if (args[0].equals("Double")) object = new Double(0.4);

            if (i >= 0)
                objects [i] = object;
            else
            {
                object = null; // Discard the warm up object
                runGC ();
                heap1 = usedMemory (); // Take a before heap snapshot
            }
        }
        runGC ();
        long heap2 = usedMemory (); // Take an after heap snapshot:

        final int size = Math.round (((float)(heap2 - heap1))/count);
//        System.out.println ("'before' heap: " + heap1 +
//                ", 'after' heap: " + heap2);
//        System.out.println ("heap delta: " + (heap2 - heap1) +
//                ", {" + objects [0].getClass () + "} size = " + size + " bytes");
        System.out.println (objects [0].getClass () + " size = " + size + " bytes\n");
        for (int i = 0; i < count; ++ i) objects [i] = null;
        objects = null;
    }
    private static void runGC () throws Exception
    {
        // It helps to call Runtime.gc()
        // using several method calls:
        for (int r = 0; r < 4; ++ r) _runGC ();
    }
    private static void _runGC () throws Exception
    {
        long usedMem1 = usedMemory (), usedMem2 = Long.MAX_VALUE;
        for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++ i)
        {
            s_runtime.runFinalization ();
            s_runtime.gc ();
            Thread.currentThread ().yield ();

            usedMem2 = usedMem1;
            usedMem1 = usedMemory ();
        }
    }
    private static long usedMemory ()
    {
        return s_runtime.totalMemory () - s_runtime.freeMemory ();
    }

    private static final Runtime s_runtime = Runtime.getRuntime ();
} // End of class
