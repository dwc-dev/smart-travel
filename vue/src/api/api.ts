import type { ITravelScenicItem } from '@/components/type';

let baseUrl;
let baseUiUrl;

if (process.env.NODE_ENV === 'development') {
  baseUrl = new URL('http://localhost:8080/');
  baseUiUrl = new URL('http://localhost/');
}

const travelOpenapiURL = new URL('travel-openapi/', baseUrl);
const userURL = new URL('user/', baseUiUrl);

/**
 * 获取旅游景区列表
 * @returns 旅游景区列表
 */
export const fetchTravelScenicList = async () => {
  const response = await fetch(new URL('scenic', travelOpenapiURL));

  if (!response.ok) {
    throw new Error(JSON.stringify(await response.json()));
  }

  return (await response.json()) as ITravelScenicItem[];
};

export const navigateToBuyPage = (scenicId: number) => {
  window.open(new URL(`buy?scenicId=${scenicId}`, userURL));
};
