import filterImg from '../assets/filter.svg'

export function Filter() {
    return (
        <div className='flex items-center h-12'>

            <button className='w-6 h-6 absolute right-10' type="button"> 
                <img src={filterImg} alt="Botão para filtrar/pesquisar filmes" />
            </button>

        </div>
    );
}