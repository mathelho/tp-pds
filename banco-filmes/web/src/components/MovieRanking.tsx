import { useEffect, useState } from "react";
import { Movie } from "./MovieList";

export function MovieRanking() {
    const [rankingList, setRankingList] = useState<Movie[]>([]);

    useEffect(() => {
        fetch('http://localhost:8080/movies/top')
        .then(response => response.json())
        .then(data => setRankingList(data))
    }, [])

    return (
        <>
            <div>Top 10</div>
        </>
    );
}