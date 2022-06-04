import { useEffect, useState } from "react";
import { FilterButton } from "./FilterButton";
import { MovieCard } from "./MovieCard";
import { MovieInfo } from "./MovieInfo";
import { MovieRanking } from "./MovieRanking";

export interface Movie {
    id: number,
    title: string,
    director: string,
    score: number,
    synopsis: string,
    genres: string[],
    whereToWatch: string[],
    imageUrl: string,
    advisoryRating: string
}

interface MovieListProps {
    onHomeOpen: boolean,
    onRankingOpen: boolean,
    setIsHomeOpen: React.Dispatch<React.SetStateAction<boolean>>,
    setIsRankingOpen: React.Dispatch<React.SetStateAction<boolean>>
}

export function MovieList({ onHomeOpen, onRankingOpen, setIsHomeOpen, setIsRankingOpen }: MovieListProps) {
    const [movieList, setMovieList] = useState<Movie[]>([]);
    const [movieChosen, setMovieChosen] = useState<Movie | null>(null);

    useEffect(() => {
        if (onHomeOpen) {
            fetch('http://localhost:8080/movies')
            .then(response => response.json())
            .then(data => setMovieList(data))

            setIsRankingOpen(false);
        }
    }, [onHomeOpen])

    useEffect(() => {
        if (movieChosen) {
            setIsHomeOpen(false);
        }
    }, [movieChosen])

    useEffect(() => {
        if (onRankingOpen) {
            setIsHomeOpen(false);
        }
    }, [onRankingOpen])

    return (
        <>
            {onHomeOpen ? (
                <>
                    <FilterButton movieList={movieList} setMovieList={setMovieList} setIsHomeOpen={setIsHomeOpen} />

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
                        <MovieRanking />
                    ) : (
                        <MovieInfo movieChosen={movieChosen} />
                    )}
                </>
            )}
        </>
        
    );
}