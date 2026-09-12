public class GamingPCDirector {
    public GamingPC buildBudgetPC(GamingPC.Builder builder) {
        return builder
                .setCpu("Intel Core i3")
                .setGpu("NVIDIA RTX 3070")
                .setRam(16)
                .setStorage(1024)
                .setOperatingSystem("Windows 11")
                .setCooling("Air Cooling")
                .build();
    }
    public GamingPC buildHighEndPC(GamingPC.Builder builder) {
        return builder
                .setCpu("Intel Core i9")
                .setGpu("NVIDIA RTX 5090")
                .setRam(32)
                .setStorage(4096)
                .setOperatingSystem("Windows 11")
                .setCooling("Liquid Cooling")
                .build();
    }
}