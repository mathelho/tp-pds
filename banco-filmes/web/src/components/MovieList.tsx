import { useEffect, useState } from "react";
import { FilterButton } from "./FilterButton";
import { MovieCard } from "./MovieCard";

interface BancoDeFilmes {
    id: number,
    title: string,
    director: string,
    score: number,
    synopsis: string,
    genre: string,
    whereToWatch: string,
    imageUrl: string
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
                        return <MovieCard key={movie.id} title={movie.title} score={movie.score} />
                    })}
                </div>
            </section>
        </>
    );
}