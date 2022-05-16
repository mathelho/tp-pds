import { Popover } from '@headlessui/react';
import filterImg from '../assets/filter.svg'
import { FilterModal } from './FilterModal';

export function FilterButton() {
    return (
        <Popover className='flex items-center h-12'>
            <Popover.Panel>
                <FilterModal />
            </Popover.Panel>

            <Popover.Button className='w-6 h-6 absolute right-10' title='Botão de filtro'>
                <img src={filterImg} alt="Botão para filtrar/pesquisar filmes" />
            </Popover.Button>
        </Popover>
    );
}