import { useState } from "react";
import { Header } from "./components/Header";
import { Movie, MovieList } from "./components/MovieList";

export function App() {
  const [isHomeOpen, setIsHomeOpen] = useState(true);
  const [isRankingOpen, setIsRankingOpen] = useState(false);
  const [isWatchListOpen, setIsWatchListOpen] = useState(false);
  const [movieList, setMovieList] = useState<Movie[]>([]);

  return (
    <>
      <Header 
        setIsHomeOpen={setIsHomeOpen}
        setIsRankingOpen={setIsRankingOpen}
        setIsWatchListOpen={setIsWatchListOpen}
        setMovieList={setMovieList}
      />

      <MovieList 
        movieList={movieList}
        setMovieList={setMovieList}
        onHomeOpen={isHomeOpen} 
        onRankingOpen={isRankingOpen}
        onWatchListOpen={isWatchListOpen}
        setIsHomeOpen={setIsHomeOpen} 
        setIsRankingOpen={setIsRankingOpen}
        setIsWatchListOpen={setIsWatchListOpen}
      />

    </>
  );
}