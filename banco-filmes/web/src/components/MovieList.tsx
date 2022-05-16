import { useEffect, useState } from "react";
import { FilterButton } from "./FilterButton";
import { MovieCard } from "./MovieCard";

interface BancoDeFilmes {
    id: number,
    name: string,
    director: string,
    score: number
}

export function MovieList() {
    const [movieList, setMovieList] = useState<BancoDeFilmes[]>([]);

    useEffect(() => {
        fetch('http://localhost:8080/movies')
        .then(response => response.json())
        .then(data => setMovieList(data))
    }, [])

    return (
        <>
            <FilterButton />

            <section className="mx-auto my-0 px-10">

                <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-6 gap-y-3">
                    {movieList.map(movie => {
                        console.log(movie);
                        return <MovieCard key={movie.id} name={movie.name} score={movie.score} />
                    })}
                </div>
            </section>
        </>
    );
}