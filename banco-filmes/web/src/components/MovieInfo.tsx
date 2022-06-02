import { Movie } from "./MovieList";

import imdbImg from '../assets/imdb_icon.svg'
import starImg from '../assets/star.svg'
import primeImg from '../assets/prime_video.svg'

interface MovieInfoProps {
    movieChosen: Movie | null,
}

const streamingTypes = {
    AMAZON_PRIME_VIDEO: {
        image: {
            source: primeImg,
            alt: 'Ícone do Amazon Prime Video'
        }
    }
}

export function MovieInfo({ movieChosen }: MovieInfoProps) {

    return (
        <>
            <section className="flex justify-center m-4">
                <img 
                    src={movieChosen?.imageUrl} 
                    alt="Poster do filme"
                    className="w-[20%]"
                />

                <div className="mx-8">
                    {movieChosen?.title}

                    <p className="mt-10">
                        {movieChosen?.synopsis}
                    </p>

                    <div className="flex flex-row items-center justify-between mt-10">

                        <div className="flex flex-col items-center">
                            <p>Nota IMDB</p>

                            <div className="flex flex-row items-center">
                                <img className="w-12 h-12" src={imdbImg} alt="Ícone do IMDB" />
                                <p className="ml-2">{`${movieChosen?.score}/10`}</p>
                            </div>
                        </div>

                        <div className="flex flex-col items-center">
                            <p>Nota dos usuários</p>
                            
                            <div className="flex flex-row items-center">
                                <img className="w-12 h-12" src={starImg} alt="Ícone do IMDB" />
                                <p className="ml-2">{`??/10`}</p>
                            </div>
                        </div>

                    </div>

                </div> {/* final da seção lateral com título e sinopse */}
            </section>

            <section className="flex justify-center items-center mt-10">
                <div className="w-[200px] h-20 p-2 mx-2 border-[1px] border-[#CA7613] rounded-lg">
                    <p>Opções para assistir:</p>

                </div>

                <button className="w-[200px] h-12 p-2 mx-2 border-[1px] border-[#CA7613] rounded-lg">
                    <p>Avaliar o filme</p>
                </button>

                <button className="w-[200px] h-12 p-2 mx-2 border-[1px] border-[#CA7613] rounded-lg">
                    <p>Add</p>
                </button>
            </section>
        </>
    );
}