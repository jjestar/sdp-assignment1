# Gaming PC Builder

Assignment project uses the **Builder Design Pattern** in Java for making custom gaming PC configurations.

---

## 1. Product & Architecture

A gaming PC consists of multiple optional and required components (CPU, GPU, RAM, Storage, OS, Cooling). Constructing it through a giant constructor can lead to confusing parameter lists. The Builder pattern isolates object creation logic and provides standard presets.

### Pattern Components
* **`GamingPC`**: Product class representing the complex PC configuration
* **`GamingPC.Builder`**: Inner builder class handling step-by-step setup with method chaining
* **`GamingPCDirector`**: Pre-configures standard builds (Budget vs. High-End)
* **`Main`**: Client class demonstrating the builder and printing configurations
---

## 2. Clean Code Principles Applied

### Principle 1: Meaningful Names
**Before:**
```
void set1(String x) { this.x = x; }

```

**After:**

```
public Builder setOperatingSystem(String operatingSystem) {
    this.operatingSystem = operatingSystem;
    return this;
}

```

*Why:* Method names state explicitly which component is being assigned, avoiding confusion during setup.

---

### Principle 2: Small Methods & Single Responsibility

**Before:**

```
public GamingPC build() {
    if (cpu == null || gpu == null) {
        throw new IllegalStateException("Missing core hardware");
    }
    return new GamingPC(this);
}

```

**After:**

```
public GamingPC build() {
    validate();
    return new GamingPC(this);
}

private void validate() {
    if (cpu == null || gpu == null) {
        throw new IllegalStateException("CPU and GPU are required.");
    }
}

```

*Why:* `build()` delegates checking logic to a dedicated `validate()` helper method, keeping each method small and focused on one task.

---

### Principle 3: Single Responsibility Principle (SRP)

**Before:**
`GamingPC` class directly handled preset choices, console rendering, and construction state inside a single file.

**After:**
Split into dedicated classes:

* `GamingPC` stores state.
* `GamingPC.Builder` builds instances.
* `GamingPCDirector` handles preset templates.
* `Main` runs execution tests.

---

### Principle 4: Validated Construction

**Before:**

```

public GamingPC build() {
    return new GamingPC(this);
}

```

**After:**

```
private void validate() {
    if (ram <= 0 || storage <= 0) {
        throw new IllegalArgumentException("RAM and Storage must be positive values.");
    }
}

```

*Why:* Ensures invalid or broken objects are never instantiated, throwing immediate exceptions on invalid input.

---

### Principle 5: Replacing Magic Arguments with Explicit Calls

**Before:**

```
GamingPC pc = new GamingPC("Intel i5", "RTX 4060", 16, 512, "Win11", "Air");

```

**After:**

```
GamingPC pc = new GamingPC.Builder()
        .setCpu("Intel Core i5")
        .setGpu("NVIDIA RTX 4060")
        .setRam(16)
        .setStorage(512)
        .build();

```
