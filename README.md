Project Architecture
GamingPC: The main model holding PC specs (CPU, GPU, RAM, storage, OS, cooling).

GamingPC.Builder: Builder class that handles step-by-step configuration with method chaining.

GamingPCDirector: Predefines preset builds so you don't have to manually configure common rigs (like budget or high-end options).

Main: Tests the builder and prints out the results.

Method Chaining
Setters in Builder return this so calls can be chained together:

```
public Builder setRam(int ram) {
    this.ram = ram;
    return this;
}
```
Creating a PC looks like this:

```
GamingPC pc = new GamingPC.Builder()
        .setCpu("Intel Core i5")
        .setGpu("NVIDIA RTX 4060")
        .setRam(16)
        .setStorage(512)
        .build();
```
Clean Code Notes
Clear naming: Setters are named directly after what they set (setOperatingSystem) instead of using vague names.

Refactored build(): Keeps build() clean by moving data checks into a separate validate() helper.

Single Responsibility: Everything is separated into its own class (Model, Builder, Director, and Main runner).

Validation: Checks for missing components before returning the instance and throws an exception if something vital is missing.

No positional argument mess: Setters make it clear what each value belongs to.
