import InputField from "@/components/InputField";
import { Button } from "@/components/ui/button";

type Props = {
    storeSelect: React.ReactNode;
    productSelect: React.ReactNode;
};
export default function Form({ storeSelect, productSelect }: Props) {
    return (
        <form className="w-full min-w-3xs px-10 flex gap-2 flex-col items-left py-16 rounded-2xl bg-black/20">
            {storeSelect}
            {productSelect}
            <InputField
                name="quantity"
                labelText="Cantidad:"
                placeholder="Ej: 1"
            />
            <Button>Añadir</Button>
        </form>
    );
}
