import { Label } from "./ui/label";
import { Input } from "./ui/input";
import { cn } from "@/lib/utils";

type Props = Omit<React.ComponentProps<"input">, "name"> & {
    labelText: string;
    name: string;
};

export default function InputField({
    labelText,
    name,
    className,
    ...props
}: Props) {
    return (
        <>
            <Label htmlFor={name} className="text-xl">
                {labelText}
            </Label>
            <Input
                name={name}
                id={name}
                className={cn("placeholder:text-xl py-6", className)}
                {...props}
            />
        </>
    );
}
