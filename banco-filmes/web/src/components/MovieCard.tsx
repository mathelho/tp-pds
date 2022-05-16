interface MovieCardProps {
    title: string,
    score: number
}

export function MovieCard({title, score}: MovieCardProps) {
    return (
        <div className="w-32 h-48 p-2 break-all bg-transparent text-white rounded-2xl border-2 hover:border-[#CA7613] hover:cursor-pointer transition-all">
            {title}, {score}
        </div>
    );
}