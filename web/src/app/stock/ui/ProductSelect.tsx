"use client";
import {
    Select,
    SelectContent,
    SelectGroup,
    SelectItem,
    SelectLabel,
    SelectTrigger,
    SelectValue,
} from "@/components/ui/select";
import { Product } from "@/lib/Product";

export default function ProductSelect({ products }: { products: Product[] }) {
    return (
        <Select>
            <SelectTrigger>
                <SelectValue placeholder="Seleccione un producto" />
            </SelectTrigger>
            <SelectContent>
                <SelectGroup>
                    <SelectLabel>Locales</SelectLabel>
                    {products.map((store) => (
                        <SelectItem
                            key={store.id}
                            value={String(store.id)}
                        >{`${store.skuCode} - ${store.description}`}</SelectItem>
                    ))}
                </SelectGroup>
            </SelectContent>
        </Select>
    );
}
