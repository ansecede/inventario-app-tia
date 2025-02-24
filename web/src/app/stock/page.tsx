import { getProducts } from "@/api/Product";
import { getStores } from "@/api/Store";
import Form from "./ui/Form";
import Table from "./ui/Table";
import StoreSelect from "./ui/StoreSelect";
import ProductSelect from "./ui/ProductSelect";

export default async function StockPage() {
    const stores = await getStores();
    const products = await getProducts();

    return (
        <div className="h-full p-10 grid grid-cols-[20%_80%]">
            <Form
                storeSelect={<StoreSelect stores={stores} />}
                productSelect={<ProductSelect products={products} />}
            />
            <Table></Table>
        </div>
    );
}
