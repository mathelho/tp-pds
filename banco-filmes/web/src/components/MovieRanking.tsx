import { useEffect, useState } from "react";
import { Movie } from "./MovieList";

interface MovieRankingProps {
    setMovieChosen: React.Dispatch<React.SetStateAction<Movie | null>>
}

export function MovieRanking({ setMovieChosen }: MovieRankingProps) {
    const [rankingList, setRankingList] = useState<Movie[]>([]);

    useEffect(() => {
        fetch('http://localhost:8080/movies/top')
        .then(response => response.json())
        .then(data => setRankingList(data))
    }, [])

    return (
        <>
            <section className="flex flex-col items-center mt-8">
                <h1 className="text-2xl font-extrabold">Top 10</h1>

                {rankingList.map((movie, rankingNumber = 0) => {
                    rankingNumber++;
                    
                    return (
                        <div key={movie.id} onClick={() => setMovieChosen(movie)} className="flex flex-row my-6 w-[50%] hover:cursor-pointer hover:brightness-90">
                            <img
                                src={movie.imageUrl}
                                alt={`Poster do filme ${movie.title}`}
                                className="w-[204px] h-[303px] rounded-2xl"
                            />

                            <div className="flex flex-col ml-8">
                                <h2 className="text-xl font-bold">{`${rankingNumber} - ${movie.title}`}</h2>

                                <p className="mt-10">{movie.synopsis}</p>
                            </div>

                        </div>
                    )
                })}
            </section>
        </>
    );
}