import { CloseButton } from "./CloseButton";

export function FilterModal() {
    return (
        <div className="bg-black absolute left-0 right-0 mx-auto text-white w-[70%] mt-16 p-10 rounded-3xl opacity-95">
            <h1 className="text-[32px] mb-3">Filtro</h1>
            <CloseButton />

            <h2 className="text-xl mb-2">Título</h2>
            <input className="w-full h-8 p-4 rounded-md bg-transparent border-2 border-[#CA7613]" type='text' placeholder="Busque pelo título..."></input>

            <h2 className="text-xl my-3">Gênero</h2>
            <select className="w-[50%] h-8 rounded-md bg-transparent border-2 border-[#CA7613]" name="genre" id="genre">
                <option className="text-black" defaultValue={''}>Selecione um gênero...</option>
                <option className="text-black" value="acao">Ação</option>
                <option className="text-black" value="comedia">Comédia</option>
            </select>
        </div>
    );
}