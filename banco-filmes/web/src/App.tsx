import { useState } from "react";
import { Header } from "./components/Header";
import { MovieList } from "./components/MovieList";

export function App() {
  const [isHomeOpen, setIsHomeOpen] = useState(true);

  return (
    <>
      <Header setIsHomeOpen={setIsHomeOpen} />
      <MovieList onHomeOpen={isHomeOpen} setIsHomeOpen={setIsHomeOpen} />
    </>
  );
}