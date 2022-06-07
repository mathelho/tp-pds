import { Popover } from "@headlessui/react";
import { FormEvent, useState } from "react";
import { CloseButton } from "./CloseButton";
import { Movie } from "./MovieList";

interface FilterModalProps {
    movieList: Movie[],
    setMovieList: React.Dispatch<React.SetStateAction<Movie[]>>,
    setIsHomeOpen: React.Dispatch<React.SetStateAction<boolean>>;
}

export function FilterModal({ movieList, setMovieList, setIsHomeOpen }: FilterModalProps) {
    const [titleQuery, setTitleQuery] = useState(''); // armazena o texto do input de título
    const [genreQuery, setGenreQuery] = useState(''); // armazena o texto do input de gênero
    const [imdbScoreQuery, setimdbScoreQuery] = useState(0); // armazena a número do input de nota

    function handleFilter() {
    
        console.log(titleQuery, genreQuery, imdbScoreQuery);
        let filteredMovieList;

        if(genreQuery != '')
            filteredMovieList = movieList.filter(movie => ((movie.title.toUpperCase().includes(titleQuery.toUpperCase())) && (movie.imdbScore >= imdbScoreQuery) && (movie.genres.includes(genreQuery))));
        else
            filteredMovieList = movieList.filter(movie => ((movie.title.toUpperCase().includes(titleQuery.toUpperCase())) && (movie.imdbScore >= imdbScoreQuery)));

        setMovieList(filteredMovieList);
        
    }

    return (
        <div className="flex flex-col flex-wrap bg-black absolute left-0 right-0 mx-auto text-white w-[70%] mt-16 p-10 rounded-3xl opacity-95">
            <h1 className="text-[32px] mb-3">Filtro</h1>
            <CloseButton />

            <h2 className="text-xl mb-2">Título</h2>
            <input 
                className="w-full h-8 p-4 rounded-md bg-transparent border-2 border-[#CA7613]" 
                type='text' 
                placeholder="Busque pelo título..."
                onChange={event => setTitleQuery(event.target.value)}
            >    
            </input>

            <div className="flex flex-col">
                <h2 className="text-xl my-3">Gênero</h2>
                <select 
                    className="w-[50%] h-8 rounded-md bg-transparent border-2 border-[#CA7613]" 
                    name="genre" 
                    id="genre"
                    onChange={event => setGenreQuery(event.target.value)}
                >
                        <option className="text-black" defaultValue={''}>Selecione um gênero...</option>
                        <option className="text-black" value="ACTION">Ação</option>
                        <option className="text-black" value="ADVENTURE">Aventura</option>
                        <option className="text-black" value="COMEDY">Comédia</option>
                        <option className="text-black" value="DRAMA">Drama</option>
                        <option className="text-black" value="FANTASY">Fantasia</option>
                        <option className="text-black" value="HORROR">Horror</option>
                        <option className="text-black" value="HISTORICAL">Histórico</option>
                        <option className="text-black" value="MYSTERY">Mistério</option>
                        <option className="text-black" value="ROMANCE">Romance</option>
                        <option className="text-black" value="SCIENCE_FICTION">Ficção Científica</option>
                        <option className="text-black" value="THRILLER">Thriller</option>
                </select>

                <h2 className="text-xl mb-2">Buscar por nota do IMDB</h2>
                <input
                    className="w-20 h-8 p-4 rounded-md bg-transparent border-2 border-[#CA7613]"
                    type="number"
                    min="0"
                    max="10"
                    step="0.5"
                    placeholder="0"
                    onChange={event => setimdbScoreQuery(Number(event.target.value))}
                >
                </input>


            </div>

            <Popover.Button onClick={handleFilter} className='absolute right-6 bottom-6'>
                Buscar
            </Popover.Button>
        </div>
    );
}