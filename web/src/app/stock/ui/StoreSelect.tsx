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
import { Store } from "@/lib/Store";
import { useState } from "react";

export default function StoreSelect({ stores }: { stores: Store[] }) {
    return (
        <Select>
            <SelectTrigger>
                <SelectValue placeholder="Seleccione un local" />
            </SelectTrigger>
            <SelectContent>
                <SelectGroup>
                    <SelectLabel>Locales</SelectLabel>
                    {stores.map((store) => (
                        <SelectItem
                            key={store.id}
                            value={String(store.id)}
                        >{`${store.numName} - ${store.name}`}</SelectItem>
                    ))}
                </SelectGroup>
            </SelectContent>
        </Select>
    );
}
