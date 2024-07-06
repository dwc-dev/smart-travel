import type { ITravelScenicItem } from '@/components/type';

let baseUrl;

if (process.env.NODE_ENV === 'development') {
  baseUrl = new URL('http://localhost:8080/');
}

const travelOpenapiURL = new URL('travel-openapi/', baseUrl);

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
