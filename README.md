# Gravity Probe Simulator

[![Build](https://github.com/sharatok/gravity-probe-simulator/actions/workflows/build.yml/badge.svg)](https://github.com/sharatok/gravity-probe-simulator/actions/workflows/build.yml)

A small Java console program that simulates a probe falling freely toward Earth from a given height.
It uses Newton's law of universal gravitation, so the acceleration grows as the probe gets closer to the surface:

```
a = G * Me / (Re + h)^2
```

The simulation advances in 0.01 s steps and prints the probe's state once every simulated second,
until either the observation time ends or the probe reaches the surface.

## Constants

| Symbol | Meaning                 | Value                      |
|--------|-------------------------|----------------------------|
| `G`    | Gravitational constant  | 6.6743 × 10⁻¹¹ N·m²/kg²    |
| `Me`   | Mass of Earth           | 5.972 × 10²⁴ kg            |
| `Re`   | Mean radius of Earth    | 6 371 000 m                |

## Modes

1. **Basic values** – probe of 10 kg dropped from 1000 m, observed for 100 s.
2. **Own values** – choose meters or kilometers, then enter:
   - mass of the object (kg)
   - initial height above the surface
   - observation time (s)

Enter `0` at a menu to exit.

## Output

Every second the program prints:

- position above Earth's surface (m or km)
- current velocity (m/s)
- current acceleration (m/s²)
- elapsed observation time (s)

When the height drops below zero it reports the time at which the probe reached the surface.

## Build and run

Requires JDK 8 or newer.

```bash
javac -d out src/Main.java
java -cp out Main
```

Or as a JAR:

```bash
jar cfe gravity-probe-simulator.jar Main -C out .
java -jar gravity-probe-simulator.jar
```

## CI

A GitHub Actions workflow (`.github/workflows/build.yml`) compiles the code, packages a JAR,
runs a quick smoke test with the basic values, and uploads the JAR as a build artifact
on every push and pull request to `main`.
