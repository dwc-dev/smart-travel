<template>
  <div class="app">
    <div class="container" ref="fContainerRef">
      <FsBookVirtualWaterfall
        :request="getData"
        :gap="15"
        :page-size="20"
        :column="column"
        :enter-size="column * 2"
      >
        <template #item="{ item, imageHeight }">
          <FsBookCard
            :detail="{
              imageHeight,
              title: item.title,
              address: item.address,
              imageUrl: item.imageUrl,
              bgColor: item.bgColor,
            }"
          />
        </template>
      </FsBookVirtualWaterfall>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue';

import FsBookCard from './components/FsBookCard.vue';
import FsBookVirtualWaterfall from './components/FsBookVirtualWaterfall.vue';

import type { ICardItem } from './components/type';

const fContainerRef = ref<HTMLDivElement | null>(null);
const column = ref(6);
const fContainerObserver = new ResizeObserver((entries) => {
  changeColumn(entries[0].target.clientWidth);
});

const changeColumn = (width: number) => {
  if (width >= 960) {
    column.value = 5;
  } else if (width >= 690) {
    column.value = 4;
  } else if (width >= 500) {
    column.value = 3;
  } else {
    column.value = 2;
  }
};

onMounted(() => {
  if (fContainerRef.value) {
    fContainerObserver.observe(fContainerRef.value);
  }
});

onUnmounted(() => {
  if (fContainerRef.value) {
    fContainerObserver.unobserve(fContainerRef.value);
  }
});

const getData = async (
  page: number,
  pageSize: number,
): Promise<ICardItem[]> => {
  if (page > 1) {
    return [];
  }

  try {
    const response = await fetch('http://localhost:8080/travel-openapi/scenic');

    if (!response.ok) {
      throw new Error(JSON.stringify(await response.json()));
    }

    const data: ICardItem[] = [];

    for (const item of await response.json()) {
      data.push(
        await new Promise((resolve) => {
          let address: string;
          if (item.province === item.city) {
            address = `${item.province}-${item.district}`;
          } else {
            address = `${item.province}-${item.city}-${item.district}`;
          }

          if (item.imageUrl) {
            const img = new Image();
            img.src = item.imageUrl;
            img.onload = function () {
              resolve({
                id: item.scenicId,
                title: item.name,
                address,
                imageUrl: item.imageUrl,
                bgColor: 'red',
                width: img.width,
                height: img.height,
              });
            };
          } else {
            resolve({
              id: item.scenicId,
              title: item.name,
              address,
              imageUrl: '',
              bgColor: 'red',
              width: 100,
              height: 120,
            });
          }
        }),
      );
    }

    return data;
  } catch (error) {
    alert(error);
    throw error;
  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
</style>

<style scoped lang="scss">
.app {
  width: 100%;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;

  .container {
    width: 1400px;
    height: 600px;
    border: 1px solid red;
  }
}
</style>
