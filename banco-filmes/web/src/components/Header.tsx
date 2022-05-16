import logoImg from '../assets/logo.svg'
import rankingImg from '../assets/ranking.svg'

export function Header() {
    return (
        <header className="bg-[#CA7613] w-full h-16">

            <button className='px-3 py-2' type='button'>
                <img src={logoImg} alt="Logo do Banco de Filmes" />
            </button>

            <button className='absolute top-3 right-12' type='button'>
                <img src={rankingImg} alt="Botão para acessar ranking de filmes" />
            </button>

        </header>
    );
}