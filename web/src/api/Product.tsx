"use server";
import { Product } from "@/lib/Product";
import { FormState } from "@/lib/types";

export async function registerProduct(state: FormState, formData: FormData) {
    const productData = {
        skuCode: formData.get("skuCode"),
        price: formData.get("price"),
        description: formData.get("description"),
    };
    const res = await fetch("http://localhost:8080/api/v1/products", {
        method: "POST",
        body: JSON.stringify(productData),
        headers: {
            "content-type": "application/json",
        },
    });

    const data = (await res.json()) as Product;

    return { message: "Producto añadido correctamente", data: data };
}
