# 🧩 SudokuApp

An advanced Sudoku game built with **vanilla Java and Swing** — no frameworks, no external libraries — that lets you generate and play Sudoku puzzles of **any size** — not just the traditional 9×9 grid.

### How it works under the hood

Most Sudoku apps hardcode a fixed 9×9 board. This app takes a different approach — it dynamically builds a valid puzzle for any `n×n` size you choose.

The process works in three stages:

1. **Generate a solved grid** — The app first creates a fully valid, completed `n×n` Sudoku solution using randomised number placement, ensuring every row, column, and sub-box satisfies Sudoku rules.
2. **Remove random cells** — A calculated number of cells are then cleared from the solved grid, leaving behind the clues (pre-filled numbers) and the blanks the player needs to figure out.
3. **Present the puzzle** — The resulting board is handed to the player to solve. If they get stuck, the original solution is still stored and can be revealed on request.

This "solve-first, then hide" approach guarantees that every generated puzzle has exactly one valid solution — the one that was computed at the start.

---

## Features

- **Custom grid sizes** — Enter any non-prime integer `n` to generate an `n×n` Sudoku puzzle
- **Randomized puzzle generation** — Each game produces a unique board
- **Interactive GUI** — Built with Java Swing; click number buttons to fill in cells
- **Eraser tool** — 3 uses per game to clear a filled cell
- **Answer checker** — Verify your solution with a single click
- **Reveal answer** — If you're stuck, generate the correct solution after checking

---

## How to Play

1. Launch the app — a startup window appears asking for your grid size `n`
2. Enter a **non-prime integer** (e.g. 4, 6, 9, 16) and click **Generate**
3. The Sudoku board opens with some cells pre-filled and others blank
4. Use the **number buttons** at the bottom to select a value, then click an empty cell to fill it
5. Use the **ERASER** button (up to 3 times) to clear a cell you want to redo
6. When done, click **Check** to see if your solution is correct
   - ✅ Correct → You win!
   - ❌ Incorrect → Click again to reveal the correct answer
7. Click **Close** to exit the game window

---

## Project Structure

```
sudukoApp/
├── main.java             # Entry point — startup window for choosing grid size
├── UI.java               # Main game window — layout, buttons, game flow
├── Grid.java             # Sudoku grid rendering and cell interaction
├── Box.java              # Manages box/region position indexing
├── Logic.java            # Random number generation for puzzle creation
├── FactorGenerator.java  # Utility for computing grid factors
└── tst.java              # Test/scratch file
```

---

## Requirements

- **Java JDK 8 or higher**
- A Java IDE such as [NetBeans](https://netbeans.apache.org/) (the project was created with NetBeans) or IntelliJ IDEA / Eclipse

---

## Getting Started

### Clone the repository

```bash
git clone https://github.com/ks9205124-cloud/sudukoApp.git
cd sudukoApp
```

### Compile

```bash
javac -d out *.java
```

### Run

```bash
java -cp out suduko.main
```

> **Note:** The source files belong to the `suduko` package. Make sure your compilation output directory preserves the package structure.

---

## Notes

- The grid size must be a **non-prime integer** (e.g. 4, 6, 8, 9, 10, 12 …). Entering a prime or invalid value will display an error message in the input field.
- Larger grid sizes (e.g. 16×16) are supported but may require resizing the window for comfortable play.

---

## License

This project currently uses the default NetBeans license template. See individual source files for details.
