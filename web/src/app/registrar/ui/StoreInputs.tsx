import InputField from "@/components/InputField";

export default function StoreInputs() {
    return (
        <>
            <h1 className="text-3xl mb-4">Registrar Local</h1>
            <InputField
                name="numName"
                labelText="Código de sucursal:"
                placeholder="Ej: 101"
                type="number"
                min={1}
            />
            <InputField
                name="name"
                labelText="Nombre:"
                placeholder="Ej: Centro"
            />
            <InputField
                name="address"
                labelText="Direccion:"
                placeholder="Ej: Chimborazo y Luque"
            />
        </>
    );
}
