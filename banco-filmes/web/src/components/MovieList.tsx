import { useEffect, useState } from "react";
import { FilterButton } from "./FilterButton";
import { MovieCard } from "./MovieCard";
import { MovieInfo } from "./MovieInfo";

export interface BancoDeFilmes {
    id: number,
    title: string,
    director: string,
    score: number,
    synopsis: string,
    genre: string,
    whereToWatch: string,
    imageUrl: string
}

interface MovieListProps {
    onHomeOpen: boolean,
    setIsHomeOpen: React.Dispatch<React.SetStateAction<boolean>>;
}

export function MovieList({ onHomeOpen, setIsHomeOpen }: MovieListProps) {
    const [movieList, setMovieList] = useState<BancoDeFilmes[]>([]);
    const [movieChosen, setMovieChosen] = useState<BancoDeFilmes | null>(null);

    useEffect(() => {
        if (onHomeOpen) {
            fetch('http://localhost:8080/movies')
            .then(response => response.json())
            .then(data => setMovieList(data))
        }
    }, [onHomeOpen])

    useEffect(() => {
        if (movieChosen) {
            setIsHomeOpen(false);
        }
    }, [movieChosen])

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
                <MovieInfo movieChosen={movieChosen} />
            )}
        </>
        
    );
}