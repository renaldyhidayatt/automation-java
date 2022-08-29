import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import com.sun.management.OperatingSystemMXBean;

public class CpuMemoryCheck {
    public static void main(String[] args){
        com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        long physicalMemorySize = os.getTotalPhysicalMemorySize();
        long freePhysicalMemory = os.getFreePhysicalMemorySize();
        long freeSwapSize = os.getFreeSwapSpaceSize();
        long commitedVirtualMemorySize = os.getCommittedVirtualMemorySize();

        System.out.println("Total physical in MB: "+(physicalMemorySize/1024)/1024);
        System.out.println("freePhysicalMemory in MB: : "+ (freePhysicalMemory/1024)/1024);

        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        System.out.println(osBean.getProcessCpuLoad() * 100);
        System.out.println(osBean.getProcessCpuLoad());

        System.out.println(osBean.getSystemCpuLoad() * 100);


    }
}
