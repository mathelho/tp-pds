import { FilterButton } from "./FilterButton";
import { MovieCard } from "./MovieCard";

export function MovieList() {
    return (
        <>
            <FilterButton />

            <section className="mx-auto my-0 px-10">

                <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-6 gap-y-3">
                    <MovieCard />
                    <MovieCard />
                    <MovieCard />
                    <MovieCard />
                    <MovieCard />
                    <MovieCard />
                    <MovieCard />
                </div>
            </section>
        </>
    );
}