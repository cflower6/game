# Game (Java) — WIP

A tiny Java game I’m building to learn the fundamentals of game loops, rendering, and input handling. Work in progress.

> Repo: `cflower6/game` (Java project with `src/` and `resource/` folders; initial commit on Oct 30, 2025).

---

## ✨ Goals

- Build a minimal render loop (update → render → sleep)
- Keyboard input and basic player movement
- Collision with simple tile map
- Basic sprites/animations loaded from `resource/`
- Score/lives & simple game over screen

---

## 🧰 Tech Stack

- **Language:** Java (plain IntelliJ project; no Gradle/Maven yet)
- **IDE:** IntelliJ IDEA (project has `.iml` and `.idea/`)

---

## 🚀 Getting Started

### Prerequisites
- **JDK 17+** (JDK 21 also fine)
- **IntelliJ IDEA** (Community or Ultimate)

### Clone
```bash
git clone https://github.com/cflower6/game.git
cd game
```

### Open in IntelliJ
1. File → Open → select the repo folder.
2. Make sure IntelliJ detects the **Project SDK** (JDK 17+).
3. Mark `resource/` as **Resources Root** (Right-click → Mark Directory As → Resources Root).
4. Run the project by executing the **main** class (e.g., `Main`).

> If you prefer command line, you can compile/run once you know the main class:
```bash
# From repo root, assuming a package-less Main in src/
javac -d out src/*.java
java -cp out Main
```
Adjust the paths if you’re using packages (e.g., `src/com/example/...`).

---

## 📁 Project Structure

```
game/
├─ src/            # Java source (game loop, entities, input)
├─ resource/       # Sprites, maps, fonts, audio
├─ .idea/          # IntelliJ project files
├─ game.iml        # IntelliJ module file
└─ .gitignore
```
Structure inferred from the current repo layout.

---

## 🎮 Controls (planned)

- **Arrow keys / WASD:** Move
- **Esc:** Pause/Quit

_(Will update as features land.)_

---

## 🗺️ Roadmap

- [ ] Window creation & render loop
- [ ] Fixed-timestep updates (e.g., 60 FPS)
- [ ] Input handling (keyboard)
- [ ] Player sprite + animation
- [ ] Tile map + collision
- [ ] Basic HUD (score, lives)
- [ ] Sound effects/music
- [ ] Packaging as runnable JAR (IntelliJ: **Build → Build Artifacts**)

---

## 🤝 Contributing

PRs welcome once the core loop is in place!  
Ideas you can tackle:

- Asset loader for images/audio from `resource/`
- Simple physics/collision utils
- Tiled map loader (CSV/JSON)
- Basic UI components (buttons, labels)

Please open an issue to discuss bigger changes first.

---

## 🧾 License

_No license declared yet._ If you want it open source, consider adding **MIT** or **Apache-2.0**. I’ll update this section when a license is added.

---

## 📸 Notes & Tips

- Keep sprites small (e.g., 16×16 / 32×32) to start.
- Prefer a **fixed** update step and compute render interpolation.
- Separate “game state” (logic) from “presentation” (rendering).
