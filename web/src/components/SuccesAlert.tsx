import { CircleCheck } from "lucide-react";

export default function SuccesAlert({ children }: { children: string }) {
    return (
        <div className="flex gap-2 text-green-600 text-xl">
            <CircleCheck />
            {children}
        </div>
    );
}
