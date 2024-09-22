import type { ITravelScenicItem } from '@/components/type';

// const baseUrl = new URL('http://localhost:8080/');
const baseUrl = new URL(window.location.origin + '/api');
// const baseUiUrl = new URL('http://localhost/');
const baseUiUrl = new URL(window.location.origin + '/ruoyi');
baseUiUrl.hash = '#/';

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

export const navigateToBuyPage = (scenicId: string | number) => {
  const url = `${baseUiUrl.toString()}user/buy?scenicId=${scenicId}`;
  window.open(url);
};
