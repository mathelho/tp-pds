import { Popover } from '@headlessui/react';
import filterImg from '../assets/filter.svg'
import { FilterModal } from './FilterModal';
import { BancoDeFilmes } from './MovieList';

interface FilterButtonProps {
    movieList: BancoDeFilmes[];
    setMovieList: React.Dispatch<React.SetStateAction<BancoDeFilmes[]>>;
    setIsHomeOpen: React.Dispatch<React.SetStateAction<boolean>>;
}

export function FilterButton({ movieList, setMovieList, setIsHomeOpen }: FilterButtonProps) {
    return (
        <Popover className='flex items-center h-12'>
            <Popover.Panel>
                <FilterModal movieList={movieList} setMovieList={setMovieList} setIsHomeOpen={setIsHomeOpen} />
            </Popover.Panel>

            <Popover.Button className='w-6 h-6 absolute right-10' title='Botão de filtro'>
                <img src={filterImg} alt="Botão para filtrar/pesquisar filmes" />
            </Popover.Button>
        </Popover>
    );
}