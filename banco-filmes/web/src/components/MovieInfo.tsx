import { Movie } from "./MovieList";
import { Popover } from "@headlessui/react";
import { useState } from "react";

import imdbImg from '../assets/imdb_icon.svg'
import starImg from '../assets/star.svg'
import primeImg from '../assets/prime_video.svg'
import netflixImg from '../assets/netflix.svg'
import hboImg from '../assets/hbo_max.png'
import globoPlayImg from '../assets/globo_play.jpeg'
import appleTvPlusImg from '../assets/apple_tv_plus.jpeg'
import crunchyrollImg from '../assets/crunchyroll.jpeg'
import dysneyPlusImg from '../assets/dysney.jpeg'
import huluImg from '../assets/hulu.png'
import paramountPlusImg from '../assets/paramount_plus.jpeg'
import starPlusImg from '../assets/star_plus.png'

import livreImg from '../assets/livre.svg'
import dezAnosImg from '../assets/10anos.svg'
import dozeAnosImg from '../assets/12anos.svg'
import quatorzeAnosImg from '../assets/14anos.svg'
import dezesseisAnosImg from '../assets/16anos.svg'
import dezoitoAnosImg from '../assets/18anos.svg'

interface MovieInfoProps {
    movieChosen: Movie | null,
    watchList: Movie[],
    setWatchList: React.Dispatch<React.SetStateAction<Movie[]>>;
}

const streamingTypes = {
    AMAZON_PRIME_VIDEO: {
        image: {
            source: primeImg,
            alt: 'Ícone do Amazon Prime Video'
        }
    },
    NETFLIX: {
        image: {
            source: netflixImg,
            alt: 'Ícone da Netflix'
        }
    },
    HBO_MAX: {
        image: {
            source: hboImg,
            alt: 'Ícone do HBO Max'
        }
    },
    GLOBO_PLAY: {
        image: {
            source: globoPlayImg,
            alt: 'Ícone do Globo Play'
        }
    },
    APPLE_TV_PLUS: {
        image: {
            source: appleTvPlusImg,
            alt: 'Ícone do Apple TV Plus'
        }
    },
    CRUNCHYROLL: {
        image: {
            source: crunchyrollImg,
            alt: 'Ícone do Crunchyroll'
        }
    },
    HULU: {
        image: {
            source: globoPlayImg,
            alt: 'Ícone do Hulu'
        }
    },
    DISNEY_PLUS: {
        image: {
            source: dysneyPlusImg,
            alt: 'Ícone do Dysney Plus'
        }
    },
    PARAMOUNT_PLUS: {
        image: {
            source: paramountPlusImg,
            alt: 'Ícone do Paramount Plus'
        }
    },
    STAR_PLUS: {
        image: {
            source: starPlusImg,
            alt: 'Ícone do Star Plus'
        }
    }
}

const advisoryTypes = {
    LIVRE: {
        image: {
            source: livreImg,
            alt: 'Ícone de classificação livre'
        }
    },
    DEZ: {
        image: {
            source: dezAnosImg,
            alt: 'Ícone de classificação para maiores de 10 anos'
        }
    },
    DOZE: {
        image: {
            source: dozeAnosImg,
            alt: 'Ícone de classificação para maiores de 12 anos'
        }
    },
    QUATORZE: {
        image: {
            source: quatorzeAnosImg,
            alt: 'Ícone de classificação para maiores de 14 anos'
        }
    },
    DEZESSEIS: {
        image: {
            source: dezesseisAnosImg,
            alt: 'Ícone de classificação para maiores de 16 anos'
        }
    },
    DEZOITO: {
        image: {
            source: dezoitoAnosImg,
            alt: 'Ícone de classificação para maiores de 18 anos'
        }
    },
}

const genreTypes = {
    ACTION: 'Ação',
    ADVENTURE: 'Aventura',
    COMEDY: 'Comédia',
    DRAMA: 'Drama',
    FANTASY: 'Fantasia',
    HORROR: 'Terror',
    HISTORICAL: 'Histórico',
    MYSTERY: 'Mistério',
    ROMANCE: 'Romance',
    SCIENCE_FICTION: 'Ficção Científica',
    THRILLER: 'Thriller'
}

export function MovieInfo({ movieChosen, watchList, setWatchList }: MovieInfoProps) {
    const [userRatingInput, setUserRatingInput] = useState('');

    function handleRatingSubmit() {
        let rating = parseFloat(userRatingInput);
        console.log(rating);

        if (Object.is(NaN, rating) || (rating < 1 || rating > 10) ) {
            alert('Por favor, digite uma nota entre 1 e 10!')
        } else {
            fetch('http://localhost:8080/movies/rate', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json, text/plain, */*',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({"id": movieChosen?.id, "score": rating})
            }).then(response => response.json())
            .then(response => console.log(response))

            alert('Filme avaliado!');
        }
    }

    function handleAddMovieToWatchList() {
        if (watchList.find(movie => movie.id === movieChosen?.id)) {
            alert('O filme já está na sua Watch List.');
        } else {
            setWatchList(movie => [...movie, movieChosen!]);
            alert('Adicionado na Watch List!');
        }
    }

    return (
        <>
            <section className="flex justify-center m-4">
                <img 
                    src={movieChosen?.imageUrl} 
                    alt={`Poster do filme ${movieChosen?.title}`}
                    className="w-[20%] rounded-2xl"
                />

                <div className="mx-8 w-[480px]">
                    <h1 className="text-xl font-extrabold">
                        {movieChosen?.title} ({movieChosen?.releaseYear})
                    </h1>

                    <p className="font-bold mt-3">
                        Diretor: {movieChosen?.director}
                    </p>

                    <p className="font-bold mt-3">
                        Gêneros: {movieChosen?.genres.map((genre, i) => {
                            if (i + 1 === movieChosen.genres.length) {
                                return <span key={i}>{genreTypes[genre as keyof typeof genreTypes]}</span>
                            } else {
                                return <span key={i}>{genreTypes[genre as keyof typeof genreTypes]}, </span>
                            }
                        })}
                    </p>

                    <p className="mt-10">
                        {movieChosen?.synopsis}
                    </p>

                    <div className="flex flex-row items-center justify-between mt-10">

                        <div className="flex flex-col items-center">
                            <p>Nota IMDB</p>

                            <div className="flex flex-row items-center">
                                <img className="w-12 h-12" src={imdbImg} alt="Ícone do IMDB" />
                                <p className="ml-2">{`${movieChosen?.imdbScore}/10`}</p>
                            </div>
                        </div>

                        <div className="flex flex-col items-center">
                            <p>Nota dos usuários</p>
                            
                            <div className="flex flex-row items-center">
                                <img className="w-12 h-12" src={starImg} alt="Ícone do IMDB" />
                                <p className="ml-2">{`${movieChosen?.score}/10 (${movieChosen?.numberOfReviews})`}</p>
                            </div>
                        </div>

                    </div>

                </div> {/* final da seção lateral com título e sinopse */}
            </section>

            <section className="flex justify-center items-center mt-10">
                <div className="flex flex-col flex-wrap w-[200px] p-2 mx-2 border-[1px] border-[#CA7613] rounded-lg">
                    <p>Opções para assistir:</p>

                    <div className="flex gap-2">
                        {movieChosen?.whereToWatch.map(streaming => {
                            return (
                                <img
                                    key={streaming}
                                    src={streamingTypes[streaming as keyof typeof streamingTypes].image.source} 
                                    alt={streamingTypes[streaming as keyof typeof streamingTypes].image.alt}
                                    className='w-9 h-9 mt-2'
                                />
                            )
                        })}
                    </div>

                </div>

                <div className="flex flex-col flex-wrap w-[200px] p-2 mx-2 border-[1px] border-[#CA7613] rounded-lg">
                    <p>Classificação indicativa:</p>

                    <img 
                        src={advisoryTypes[movieChosen?.advisoryRating as keyof typeof advisoryTypes].image.source} 
                        alt={advisoryTypes[movieChosen?.advisoryRating as keyof typeof advisoryTypes].image.alt}
                        className="w-9 h-9 mt-2"
                    />
                </div>

                <Popover>
                    <Popover.Button className="w-[200px] h-12 p-2 mx-2 border-[1px] border-[#CA7613] rounded-lg">
                        <p>Avaliar o filme</p>
                    </Popover.Button>

                    <Popover.Panel className="flex flex-col items-center justify-center absolute p-3 top-0 bottom-0 left-0 right-0 mx-auto my-auto rounded-xl w-[466px] h-[234px] bg-black opacity-95">
                        <input 
                            className="text-black" 
                            type="text" 
                            placeholder="Digite a nota..."
                            onChange={event => setUserRatingInput(event.target.value)}
                        />

                        <Popover.Button 
                            className="h-11 w-[50%] mt-3 rounded-lg border-[1px] border-[#CA7613]"
                            onClick={handleRatingSubmit}
                        >
                            Enviar avaliação
                        </Popover.Button>
                    </Popover.Panel>
                </Popover>

                <button 
                    className="w-[200px] h-12 p-2 mx-2 border-[1px] border-[#CA7613] rounded-lg"
                    onClick={handleAddMovieToWatchList}
                >
                    <p>Add</p>
                </button>
            </section>
        </>
    );
}