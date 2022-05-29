import { Movie } from "./MovieList";

interface MovieCardProps {
    movie: Movie,
    setMovieChosen: React.Dispatch<React.SetStateAction<Movie | null>>
}

export function MovieCard({ movie, setMovieChosen }: MovieCardProps) {
    return (
        <div onClick={() => setMovieChosen(movie)} className="w-32 h-48 p-2 break-all bg-transparent text-white rounded-2xl border-2 hover:border-[#CA7613] hover:cursor-pointer transition-all">
            {movie.title}, {movie.score}
        </div>
    );
}