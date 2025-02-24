"use server";
import { Store } from "@/lib/Store";
import { FormState } from "@/lib/types";

export async function registerStore(state: FormState, formData: FormData) {
    const storeData = {
        numName: formData.get("numName"),
        name: formData.get("name"),
        address: formData.get("address"),
    };
    const res = await fetch("http://localhost:8080/api/v1/stores", {
        method: "POST",
        body: JSON.stringify(storeData),
        headers: {
            "content-type": "application/json",
        },
    });

    const data = (await res.json()) as Store;
    console.log({ data });

    return { message: "Producto añadido correctamente", data: data };
}
