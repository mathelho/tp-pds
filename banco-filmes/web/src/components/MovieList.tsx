import { useEffect, useState } from "react";
import { FilterButton } from "./FilterButton";
import { MovieCard } from "./MovieCard";
import { MovieInfo } from "./MovieInfo";
import { MovieRanking } from "./MovieRanking";
import { WatchList } from "./WatchList";

export interface Movie {
    id: number,
    title: string,
    director: string,
    score: number,
    imdbScore: number,
    synopsis: string,
    genres: string[],
    whereToWatch: string[],
    imageUrl: string,
    advisoryRating: string,
    releaseYear: string,
    numberOfReviews: number;
}

interface MovieListProps {
    onHomeOpen: boolean,
    onRankingOpen: boolean,
    onWatchListOpen: boolean,
    movieList: Movie[],
    setMovieList: React.Dispatch<React.SetStateAction<Movie[]>>,
    setIsHomeOpen: React.Dispatch<React.SetStateAction<boolean>>,
    setIsRankingOpen: React.Dispatch<React.SetStateAction<boolean>>,
    setIsWatchListOpen: React.Dispatch<React.SetStateAction<boolean>>
}

export function MovieList({ onHomeOpen, onRankingOpen, onWatchListOpen, movieList, setMovieList, setIsHomeOpen, setIsRankingOpen, setIsWatchListOpen }: MovieListProps) {
    const [watchList, setWatchList] = useState<Movie[]>([]);
    const [movieChosen, setMovieChosen] = useState<Movie | null>(null);

    useEffect(() => {
        if (onHomeOpen) {
            fetch('http://localhost:8080/movies')
            .then(response => response.json())
            .then(data => setMovieList(data))

            setIsRankingOpen(false);
            setIsWatchListOpen(false);
        }
    }, [onHomeOpen])

    useEffect(() => {
        if (movieChosen) {
            setIsHomeOpen(false);
            setIsRankingOpen(false);
            setIsWatchListOpen(false);
        }
    }, [movieChosen])

    useEffect(() => {
        if (onRankingOpen) {
            setIsHomeOpen(false);
            setIsWatchListOpen(false);
            setMovieChosen(null);
        }
    }, [onRankingOpen])

    useEffect(() => {
        if (onWatchListOpen) {
            fetch('http://localhost:8080/movies')
            .then(response => response.json())
            .then(data => setMovieList(data))

            setIsHomeOpen(false);
            setIsRankingOpen(false);
            setMovieChosen(null);
        }
    }, [onWatchListOpen])

    return (
        <>
            {onHomeOpen ? (
                <>
                    <FilterButton 
                        movieList={movieList} 
                        setMovieList={setMovieList}
                        setIsHomeOpen={setIsHomeOpen} 
                    />

                    <section className="mx-auto my-0 px-10">
                        <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-6 gap-y-3">
                            {movieList.map(movie => {
                                return <MovieCard key={movie.id} movie={movie} setMovieChosen={setMovieChosen} />
                            })}
                        </div>

                    </section>
                </>
            ) : (
                <>
                    {onRankingOpen ? (
                        <MovieRanking setMovieChosen={setMovieChosen} />
                    ) : (
                        <>
                            {onWatchListOpen ? (
                                <WatchList movieList={movieList} watchList={watchList} setWatchList={setWatchList} setMovieChosen={setMovieChosen} />
                            ) : (
                                <MovieInfo movieChosen={movieChosen} watchList={watchList} setWatchList={setWatchList} />
                            )}
                        </>
                    )}
                </>
            )}
        </>
        
    );
}