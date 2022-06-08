import logoImg from '../assets/logo.svg'
import rankingImg from '../assets/ranking.svg'
import { Movie } from './MovieList';

interface HeaderProps {
    setIsHomeOpen: React.Dispatch<React.SetStateAction<boolean>>,
    setIsRankingOpen: React.Dispatch<React.SetStateAction<boolean>>,
    setMovieList: React.Dispatch<React.SetStateAction<Movie[]>>,
    setIsWatchListOpen: React.Dispatch<React.SetStateAction<boolean>>;
}

export function Header({ setIsHomeOpen, setIsRankingOpen, setMovieList, setIsWatchListOpen }: HeaderProps) {
    return (
        <header className="bg-[#CA7613] w-full h-16 flex justify-between items-center px-3">

            <button className='py-2' type='button'>
                <img onClick={() => {
                    fetch('http://localhost:8080/movies')
                    .then(response => response.json())
                    .then(data => setMovieList(data))

                    setIsHomeOpen(true);
                }} src={logoImg} alt="Logo do Banco de Filmes" />
            </button>

            <button onClick={() => setIsWatchListOpen(true)} className='w-20 h-10 hover:brightness-105 transition-all' type='button'>
                Watch List
            </button>

            <button className='' type='button'>
                <img onClick={() => setIsRankingOpen(true)} src={rankingImg} alt="Botão para acessar ranking de filmes" />
            </button>

        </header>
    );
}