import { Movie } from "./MovieList";

interface MovieCardProps {
    movie: Movie,
    setMovieChosen: React.Dispatch<React.SetStateAction<Movie | null>>
}

export function MovieCard({ movie, setMovieChosen }: MovieCardProps) {
    return (
        <div className="flex flex-col items-center w-[50%]">
            <div onClick={() => setMovieChosen(movie)} className="w-32 h-48 break-all bg-transparent text-white rounded-2xl border-2 hover:border-[#CA7613] hover:cursor-pointer transition-all">
                <img 
                    src={movie.imageUrl} 
                    alt={`Poster do filme ${movie.title}`}
                    className="h-[100%] rounded-2xl"
                />
            </div>

            <p>{movie.title}, {movie.imdbScore}</p>
        </div>
    );
}