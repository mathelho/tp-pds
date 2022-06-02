import { useState } from "react";
import { Header } from "./components/Header";
import { MovieList } from "./components/MovieList";

export function App() {
  const [isHomeOpen, setIsHomeOpen] = useState(true);
  const [isRankingOpen, setIsRankingOpen] =  useState(false);

  return (
    <>
      <Header setIsHomeOpen={setIsHomeOpen} setIsRankingOpen={setIsRankingOpen} />
      <MovieList onHomeOpen={isHomeOpen} onRankingOpen={isRankingOpen} setIsHomeOpen={setIsHomeOpen} setIsRankingOpen={setIsRankingOpen} />
    </>
  );
}