import { Trash } from "phosphor-react";
import { Movie } from "./MovieList";

interface WatchListProps {
    movieList: Movie[],
    watchList: Movie[],
    setWatchList: React.Dispatch<React.SetStateAction<Movie[]>>,
    setMovieChosen: React.Dispatch<React.SetStateAction<Movie | null>>;
}

export function WatchList({ movieList, watchList, setWatchList, setMovieChosen }: WatchListProps) {
    
    function handleRemoveFromWatchList(movieFromList: Movie) {
        const newWatchList = watchList.filter(movie => movie != movieFromList);

        setWatchList(newWatchList);
    }

    return (
        <>
            <div className="flex flex-col items-center mt-8">
                <h1 className="text-2xl font-extrabold">Sua Watch List</h1>

                {watchList.map(movie => {
                    // necessário para acessar o filme da lista completa, e não só da watchList
                    let movieInListAll = movieList.find(allMovies => allMovies.id === movie.id);

                    return (
                        <>
                            <div id={`${movie.id}`} className="flex items-center my-8 w-[50%] hover:brightness-110 transition-all">
                                <img 
                                    src={movie.imageUrl} 
                                    alt={`Poster do filme ${movie.title}`}
                                    className="w-20 h-32 hover:cursor-pointer"
                                    onClick={() => setMovieChosen(movieInListAll!)}
                                />

                                <h2 className="ml-5">{movie.title}</h2>

                                <Trash
                                    id={`${movie.id}`}
                                    weight="bold" 
                                    size={30} 
                                    className="ml-10 hover:cursor-pointer"
                                    onClick={() => handleRemoveFromWatchList(movie)}
                                />
                                
                            </div>
                        </>
                    )
                })}

            </div>
        </>
    );
}