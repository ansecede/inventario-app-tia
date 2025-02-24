import InputField from "@/components/InputField";

export default function ProductInputs() {
    return (
        <>
            <h1 className="text-3xl mb-4">Registrar Producto</h1>
            <InputField
                name="skuCode"
                labelText="Código de sku nuevo:"
                placeholder="Ej: 123456000"
            />
            <InputField
                name="price"
                labelText="Precio:"
                placeholder="Ej: 0.99"
                type="number"
                step="0.01"
            />
            <InputField
                name="description"
                labelText="Descripción:"
                placeholder="Ej: PRODUCTO X 1KG"
            />
        </>
    );
}
