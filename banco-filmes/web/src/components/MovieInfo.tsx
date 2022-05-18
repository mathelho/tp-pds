import { BancoDeFilmes } from "./MovieList";

interface MovieInfoProps {
    movieChosen: BancoDeFilmes | null,
}

export function MovieInfo({ movieChosen }: MovieInfoProps) {

    return (
        <>
            <h1>TELA DE INFO DO FILME</h1>
            <h1>{movieChosen?.title}</h1>
        </>
    );
}