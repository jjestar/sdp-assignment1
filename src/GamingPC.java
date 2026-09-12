public class GamingPC {
    private final String cpu;
    private final String gpu;
    private final int ram;
    private final int storage;
    private final String operatingSystem;
    private final String cooling;
    private GamingPC(Builder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.operatingSystem = builder.operatingSystem;
        this.cooling = builder.cooling;
    }
    public static class Builder {
        private String cpu;
        private String gpu;
        private int ram;
        private int storage;
        private String operatingSystem;
        private String cooling;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }
        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }
        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }
        public Builder setCooling(String cooling) {
            this.cooling = cooling;
            return this;
        }
        public GamingPC build() {
            validate();
            return new GamingPC(this);
        }

        private void validate() {
            if (cpu == null || cpu.isBlank()) {
                throw new IllegalStateException("what CPU?");
            }

            if (gpu == null || gpu.isBlank()) {
                throw new IllegalStateException("what GPU?");
            }

            if (ram <= 0) {
                throw new IllegalStateException("RAM cant be less than 1");
            }
            if (storage <= 0) {
                throw new IllegalStateException("Storage cant be less than 1");
            }
            if (operatingSystem == null || operatingSystem.isBlank()) {
                throw new IllegalStateException("What OS?");
            }
            if (cooling == null || cooling.isBlank()) {
                throw new IllegalStateException("What kind of cooling?");
            }
        }
    }
    @Override
    public String toString() {
        return "GamingPC {" +
                "\n  CPU: " + cpu +
                "\n  GPU: " + gpu +
                "\n  RAM: " + ram + " GB" +
                "\n  Storage: " + storage + " GB" +
                "\n  Operating System: " + operatingSystem +
                "\n  Cooling: " + cooling +
                "\n}";
    }
}